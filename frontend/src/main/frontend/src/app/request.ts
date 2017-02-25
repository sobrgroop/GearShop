import {Product} from "./product";
export class Request {

  constructor(private _product: Product, private _count: number) {
  }

  get count(): number {
    return this._count;
  }

  set count(value: number) {
    this._count = value;
  }

  get product(): Product {
    return this._product;
  }
}
