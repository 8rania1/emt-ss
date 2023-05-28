/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 3.1.1185 on 2023-05-28 09:32:16.

export interface Alert {
    id: number;
    date: Date;
    message: string;
    category: Category;
}

export interface Category {
    id: number;
    name: string;
    description: string;
    threshold: number;
}

export interface Equipment {
    id: number;
    serialNumber: string;
    creationDate: Date;
    version: string;
    name: string;
    partNumber: string;
    available: boolean;
    category: Category;
    supplier: Supplier;
}

export interface Movement {
    id: number;
    date: Date;
    direction: MovementDirection;
    equipment: Equipment;
    status: Status;
    note: string;
    user: User;
}

export interface Notification {
    id: number;
    time: Date;
    title: string;
    message: string;
    user: User;
    read: boolean;
}

export interface Permission {
    name: string;
}

export interface Status {
    id: number;
    title: string;
    direction: MovementDirection;
}

export interface Supplier {
    id: number;
    name: string;
    email: string;
    address: string;
    mobile: string;
}

export interface User {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    mobile: string;
    password: string;
    permissions: string[];
    counts: MovementDirectionCount[];
}

export interface MovementDirectionCount {
    direction: MovementDirection;
    count: number;
}

export type MovementDirection = "IN" | "OUT";

export type Severity = "INFO" | "WARN";
