package com.sagem.emt.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.MutablePair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagem.emt.dao.entity.Category;
import com.sagem.emt.dao.entity.MovementDirection;
import com.sagem.emt.dao.entity.Status;
import com.sagem.emt.dao.repository.CategoryRepository;
import com.sagem.emt.dao.repository.EquipmentRepository;
import com.sagem.emt.dao.repository.MovementRepository;
import com.sagem.emt.dao.repository.StatusRepository;

import be.ceau.chart.BarChart;
import be.ceau.chart.PieChart;
import be.ceau.chart.data.BarData;
import be.ceau.chart.data.PieData;
import be.ceau.chart.dataset.BarDataset;
import be.ceau.chart.dataset.PieDataset;
import be.ceau.chart.options.BarOptions;
import be.ceau.chart.options.PieOptions;
import be.ceau.chart.options.Title;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chart")
public class ChartController {

	private final CategoryRepository categoryRepository;
	private final EquipmentRepository equipmentRepository;
	private final StatusRepository reasonRepository;
	private final MovementRepository movementRepository;

	@GetMapping
	public Map<String, PieChart> categories() {
		List<Category> categories = categoryRepository.findAll();
		return categories.stream().collect(Collectors.toMap(Category::getName, this::category));
	}

	@GetMapping(path = "equipments")
	public BarChart equipments() {
		List<Category> categories = this.categoryRepository.findAll();
		BarDataset dataset = new BarDataset().setLabel("available").setData(available(categories));
		BarDataset datasettt = new BarDataset().setLabel("out of stock").setData(out(categories));
		BarData data = new BarData().addLabels(categories.stream().map(Category::getName).collect(Collectors.toList())
				.toArray(new String[categories.size()])).addDataset(dataset).addDataset(datasettt);
		BarOptions options = new BarOptions().setResponsive(true).setPlugins(
				new MutablePair<String, Object>("title", new Title().setDisplay(true).setText("inventaire équipements")));
		return new BarChart(data, options);
	}

	int[] available(List<Category> categories) {
		return categories.stream()
				.mapToInt(category -> this.equipmentRepository.countByAvailableAndCategory(true, category)).toArray();

	}

	int[] out(List<Category> categories) {
		return categories.stream()
				.mapToInt(category -> this.equipmentRepository.countByAvailableAndCategory(false, category)).toArray();

	}

	@GetMapping(path = "reasons")
	public PieChart reasons() {
		List<Status> statusList = reasonRepository.findByDirection(MovementDirection.OUT);
		List<BigDecimal> counts = statusList.stream().map(movementRepository::countByStatus)
				.collect(Collectors.toList());
		List<String> reasonssss = statusList.stream().map(Status::getTitle).collect(Collectors.toList());
		PieDataset dataset = new PieDataset().setLabel("reasons").setData(counts.toArray(new BigDecimal[counts.size()]))
				.setBorderWidth(2);
		PieData data = new PieData().addLabels(reasonssss.toArray(new String[reasonssss.size()])).addDataset(dataset);

		PieOptions options = new PieOptions().setResponsive(true).setPlugins(
				new MutablePair<String, Object>("title", new Title().setDisplay(true).setText("status de sortie de stock")));
		return new PieChart(data, options);
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
