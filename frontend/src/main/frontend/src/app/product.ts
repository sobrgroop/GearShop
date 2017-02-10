import {Category} from "./category";
export class Product {

  constructor(private _id: number, private _category: Category,
              private _name: string, private _price: number, private _description: string) {
  }

  get id(): number {
    return this._id;
  }

  get category(): Category {
    return this._category;
  }

  get name(): string {
    return this._name;
  }

  get price(): number {
    return this._price;
  }

  get description(): string {
    return this._description;
  }
}
