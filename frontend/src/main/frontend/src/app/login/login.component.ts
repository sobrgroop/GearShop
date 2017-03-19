import {Component, ViewChild} from "@angular/core";
import {ModalComponent} from "ng2-bs3-modal/components/modal";
import {CartService} from "../cart.service";

const template = require('./login.component.html');
const style = require('./login.component.css');

@Component({
  selector: '.loginModal',
  template: template,
  styles: [style],
  providers: [CartService]
})
export class LoginComponent {

  @ViewChild('login')
  private modal: ModalComponent;

  private email: string;
  private password: string;

  constructor(private cartService: CartService) {
  }

  close() {
    this.modal.close();
  }

  open() {
    this.modal.open();
  }

  onSubmit() {
    this.cartService.login(this.email, this.password).subscribe((response) => {
      console.log(response._body);
      this.close();
    });
  }

}
