package com.sagem.emt.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.MutablePair;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Category;
import com.sagem.emt.dao.entity.Reason;
import com.sagem.emt.dao.repository.CategoryRepository;
import com.sagem.emt.dao.repository.EquipmentRepository;
import com.sagem.emt.dao.repository.MovementRepository;
import com.sagem.emt.dao.repository.ReasonRepository;

import be.ceau.chart.BarChart;
import be.ceau.chart.PieChart;
import be.ceau.chart.data.BarData;
import be.ceau.chart.data.PieData;
import be.ceau.chart.dataset.BarDataset;
import be.ceau.chart.dataset.PieDataset;
import be.ceau.chart.options.BarOptions;
import be.ceau.chart.options.PieOptions;
import be.ceau.chart.options.Title;
import be.ceau.chart.options.scales.BarScale;
import be.ceau.chart.options.ticks.LinearTicks;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chart")
public class ChartController {

	private final CategoryRepository categoryRepository;
	private final EquipmentRepository equipmentRepository;
	private final ReasonRepository reasonRepository;
	private final MovementRepository movementRepository;

	@GetMapping
	@PostAuthorize("hasPermission('chart', 'categories.view')")
	public Map<String, PieChart> categories() {
		List<Category> categories = categoryRepository.findAll();
		return categories.stream().collect(Collectors.toMap(Category::getName, this::category));
	}

	@GetMapping(path = "reasons")
	@PostAuthorize("hasPermission('chart', 'reasons.view')")
	public BarChart reasons() {
		List<Reason> reasons = reasonRepository.findAll();
		List<BigDecimal> counts = reasons.stream().map(movementRepository::countByReason).collect(Collectors.toList());
		List<String> reasonssss = reasons.stream().map(Reason::getTitle).collect(Collectors.toList());
		LinearTicks ticks = new LinearTicks().setMin(0).setStepSize(5);
		BarDataset dataset = new BarDataset().setLabel("reasons")
				.setData(counts.toArray(new BigDecimal[counts.size()]));
		BarData data = new BarData().addLabels(reasonssss.toArray(new String[reasonssss.size()])).addDataset(dataset);

		BarScale scale = new BarScale().addxAxes(BarScale.xAxis().setBarThickness(new BigDecimal(5)))
				.addyAxes(BarScale.yAxis().setTicks(ticks));
		BarOptions options = new BarOptions().setScales(scale).setResponsive(true);
		return new BarChart(data, options);
	}

	private PieChart category(Category category) {

		PieDataset dataset = new PieDataset().setLabel(category.getName()).setData(
				this.equipmentRepository.countByAvailableAndCategory(true, category),
				this.equipmentRepository.countByAvailableAndCategory(false, category));
		PieData data = new PieData().addLabels("available", "out of stock").addDataset(dataset);

		return new PieChart(data, new PieOptions().setResponsive(true).setPlugins(
				new MutablePair<String, Object>("title", new Title().setDisplay(true).setText(category.getName()))));

	}

}
