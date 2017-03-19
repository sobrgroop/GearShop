import {Component, OnInit, OnDestroy, ViewChild} from "@angular/core";
import {LocalStorageService} from "angular-2-local-storage";
import {Product} from "../product";
import {CartItem} from "../cart-item";
import {CartService} from "../cart.service";
import {ModalComponent} from "ng2-bs3-modal/components/modal";

const template = require('./cart.component.html');
const style = require('./cart.component.css');

@Component({
  selector: '.cartModal',
  template: template,
  styles: [style],
  providers: [CartService]
})
export class CartComponent implements OnInit, OnDestroy {

  @ViewChild('cart')
  private modal: ModalComponent;

  private cartItems: CartItem[];

  private onSetEvent: any;
  private onRemoveEvent: any;

  private phone: string;

  constructor(private localStorageService: LocalStorageService, private cartService: CartService) {
  }

  ngOnInit(): void {
    this.updateCartItems();

    this.onSetEvent = this.localStorageService.setItems$.subscribe(() =>
      this.updateCartItems()
    );

    this.onRemoveEvent = this.localStorageService.removeItems$.subscribe(() =>
      this.updateCartItems()
    );
  }

  ngOnDestroy(): void {
    this.onSetEvent.unsubscribe();
    this.onRemoveEvent.unsubscribe();
  }

  private updateCartItems(): void {
    this.cartItems = this.getStorageItems();
  }

  private getStorageItems(): CartItem[] {
    let keys: string[] = this.localStorageService.keys();
    let items: CartItem[] = new Array(keys.length);

    keys.forEach((key, i) => {
      let product: Product = JSON.parse(key);
      let count: number = Number(this.localStorageService.get(key));
      items[i] = new CartItem(product, count);
    });

    return items;
  }

  close() {
    this.modal.close();
  }

  open() {
    this.phone = '';
    this.modal.open();
  }

  onSubmit() {
    console.log(this.phone);
    this.cartService.checkout(this.phone, this.cartItems).subscribe(() => {
        console.log('success');
        this.localStorageService.clearAll();
        this.modal.close();
      }
    );
  }
}
