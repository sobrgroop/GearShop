import {Component, OnInit} from "@angular/core";
import {CategoryService} from "../category.service";

@Component({
  selector: '.dropdown-menu',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css'],
  providers: [CategoryService]
})
export class CategoryComponent implements OnInit {

  public categories;

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit() {
    this.getCategories();
  }

  getCategories() {
    this.categoryService.getCategories().subscribe(
      data => {
        this.categories = data
      },

      err => console.error(err),

      () => console.log('categories have been loaded')
    );
  }
}
