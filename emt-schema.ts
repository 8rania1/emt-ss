/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 3.1.1185 on 2023-03-19 11:40:26.

export interface Category {
    id: number;
    name: string;
    description: string;
    threshold: number;
}

export interface Equipment {
    serialNumber: string;
    creationDate: Date;
    version: string;
    name: string;
    partNumber: string;
    available: boolean;
    category: Category;
}

export interface Movement {
    id: number;
    date: Date;
    direction: MovementDirection;
    equipment: Equipment;
    reason: Reason;
    note: string;
    user: User;
}

export interface Notification {
    id: number;
    title: string;
    message: string;
    user: User;
}

export interface Reason {
    id: number;
    title: string;
    direction: MovementDirection;
}

export interface User {
    id: number;
    firstName: string;
    lastName: string;
    mail: string;
    mobile: string;
    password: string;
    role: string;
}

export type MovementDirection = "IN" | "OUT";

export type Severity = "INFO" | "WARN";
