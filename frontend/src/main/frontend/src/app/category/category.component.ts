import {Component, OnInit} from "@angular/core";
import {CategoryService} from "../category.service";

const template = require('./category.component.html');
const styles = require('./category.component.css');

@Component({
  selector: '.dropdown-menu',
  template: template,
  styles: [styles]
})
export class CategoryComponent implements OnInit {

  private categories: any;

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.categoryService.getCategories().subscribe(
      data => {
        this.categories = data
      },
      err => console.error(err)
    );
  }

}
