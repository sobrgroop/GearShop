import {Component, OnInit, OnDestroy} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {CategoryService} from "../category.service";
import {Product} from "../product";

const template = require('./product.component.html');
const styles = require('./product.component.css');

@Component({
  selector: 'app-root',
  template: template,
  styles: [styles]
})
export class ProductComponent implements OnInit, OnDestroy {

  //noinspection JSMismatchedCollectionQueryUpdate
  private products: Product[];
  private id: string;
  private sub: any;

  constructor(private categoryService: CategoryService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.id = params['id'];
      this.loadProducts();
    });
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  loadProducts(): void {
    this.categoryService.getProducts(this.id).subscribe(
      data => {
        this.products = data
      },
      err => console.error(err)
    );
  }

  //noinspection JSUnusedGlobalSymbols,JSMethodCanBeStatic
  addToCart(product: Product, count: number): void {
    console.log(product.name);
    console.log(count);
  }
}
