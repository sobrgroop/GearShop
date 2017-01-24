import {Component} from '@angular/core';
import {CategoryService} from "./category.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public categories;

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit() {
    this.getCategories();
  }

  getCategories() {
    this.categoryService.getCategories().subscribe(
      data => {this.categories = data},

      err => console.error(err),

      () => console.log('categories have been loaded')
    );
  }
}
