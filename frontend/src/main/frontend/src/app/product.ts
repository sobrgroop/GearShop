import {Category} from "./category";
export class Product {
  id: number;
  name: string;
  description: string;
  price: number;
  category: Category;

  constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}
