import {Component} from "@angular/core";
import {CategoryService} from "../category.service";

@Component({
  selector: 'app-root',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  public products;

  constructor(private categoryService: CategoryService) {
  }

  loadProducts(id) {
    this.categoryService.getProducts(id).subscribe(
      data => {
        this.products = data
      },
      err => console.error(err),
      () => console.log('products have been loaded')
    );
  }

}
