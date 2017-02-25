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

  private _products: Product[];
  private id: string;

  private onRouteEvent: any;

  constructor(private categoryService: CategoryService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.onRouteEvent = this.route.params.subscribe(params => {
      this.id = params['id'];
      this.loadProducts();
    });
  }

  ngOnDestroy(): void {
    this.onRouteEvent.unsubscribe();
  }

  loadProducts(): void {
    this.categoryService.getProducts(this.id).subscribe(
      data => {
        this._products = data
      },
      err => console.error(err)
    );
  }

  get products(): Product[] {
    return this._products;
  }

}
