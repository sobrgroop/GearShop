import {Component, OnInit} from "@angular/core";
import {CategoryService} from "../category.service";
import {Category} from "../category";

const template = require('./category.component.html');
const style = require('./category.component.css');

@Component({
  selector: '.dropdown-menu',
  template: template,
  styles: [style],
  providers: [CategoryService]
})
export class CategoryComponent implements OnInit {

  private _categories: Category[];

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.categoryService.getCategories().subscribe(
      data => {
        this._categories = data
      },
      err => console.error(err)
    );
  }

  get categories(): Category[] {
    return this._categories;
  }
}
