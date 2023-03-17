export interface Category {
    id: number;
    name: string;
    description: string;
    equipments: Equipment[];
}

export interface Equipment {
    serialNumber: string;
    version: string;
    name: string;
    partNumber: string;
    active: boolean;
    category: Category;
    movements: Movement[];
}

export interface Movement {
    id: number;
    date: Date;
    direction: MovementDirection;
    equipment: Equipment;
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
