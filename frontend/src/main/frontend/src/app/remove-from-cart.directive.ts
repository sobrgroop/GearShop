import {Directive, Input, HostListener} from "@angular/core";
import {LocalStorageService} from "angular-2-local-storage";
import {Product} from "./product";

@Directive({
  selector: '[removeFromCart]'
})
export class RemoveFromCartDirective {

  @Input('removeFromCart')
  private product: Product;

  @HostListener('click') onClick() {
    this.removeFromStorage(JSON.stringify(this.product))
  }

  constructor(private localStorageService: LocalStorageService) {
  }

  removeFromStorage(product: string): void {
    let currentCount = Number(this.localStorageService.get(product));
    if (currentCount == 1) {
      this.localStorageService.remove(product);
    } else if (currentCount > 1) {
      this.localStorageService.set(product, currentCount - 1);
    }
  }
}
