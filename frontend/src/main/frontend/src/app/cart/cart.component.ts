import {Component, OnInit, OnDestroy} from "@angular/core";
import {LocalStorageService} from "angular-2-local-storage";
import {Request} from "../request";
import {Product} from "../product";

const template = require('./cart.component.html');
const style = require('./cart.component.css');

@Component({
  selector: '.modal-dialog',
  template: template,
  styles: [style]
})
export class CartComponent implements OnInit, OnDestroy {

  private _cartItems: Request[];

  private onSetEvent: any;
  private onRemoveEvent: any;

  constructor(private localStorageService: LocalStorageService) {
  }

  ngOnInit(): void {
    this.updateCartItems();

    this.onSetEvent = this.localStorageService.setItems$.subscribe(complete => {
      this.updateCartItems();
    });
    this.onRemoveEvent = this.localStorageService.removeItems$.subscribe(complete => {
      this.updateCartItems();
    });
  }

  ngOnDestroy(): void {
    this.onSetEvent.unsubscribe();
    this.onRemoveEvent.unsubscribe();
  }

  updateCartItems(): void {
    this._cartItems = this.getStorageItems();
  }

  getStorageItems(): Request[] {
    let keys: string[] = this.localStorageService.keys();
    let items: Request[] = new Array(keys.length);
    let i: number = 0;
    for (let key of keys) {
      let product: Product = JSON.parse(key);
      let count: number = Number(this.localStorageService.get(key));
      items[i] = new Request(product, count);
      i++;
    }
    return items;
  }

  get cartItems(): Request[] {
    return this._cartItems;
  }
}
