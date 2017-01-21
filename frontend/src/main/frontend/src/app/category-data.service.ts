import { Injectable } from '@angular/core';
import {Category} from "./category";

@Injectable()
export class CategoryDataService {

  categories: Category[] = [];

  constructor() { }

  getCategories(): Category[] {
    return this.categories;
  }

}
