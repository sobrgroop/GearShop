import {Directive, Input, HostListener} from '@angular/core';
import {LocalStorageService} from "angular-2-local-storage";
import {Product} from "./product";

@Directive({
  selector: '[addToCart]'
})
export class AddToCartDirective {

  @Input('addToCart')
  private product: Product;

  @HostListener('click') onClick() {
    this.addToStorage(JSON.stringify(this.product))
  }

  constructor(private localStorageService: LocalStorageService) { }

  addToStorage(product: string): void {
    let old = this.localStorageService.get(product);
    if (old == null) {
      this.localStorageService.set(product, 1);
    } else {
      this.localStorageService.set(product, Number(old) + 1);
    }
  }
}
