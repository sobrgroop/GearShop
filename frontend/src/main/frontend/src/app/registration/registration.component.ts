import {Component, ViewChild} from "@angular/core";
import {ModalComponent} from "ng2-bs3-modal/components/modal";

const template = require('./registration.component.html');
const style = require('./registration.component.css');

@Component({
  selector: '.signUpModal',
  template: template,
  styles: [style]
})
export class RegistrationComponent {

  @ViewChild('signUp')
  private modal: ModalComponent;

  close() {
    this.modal.close();
  }

  open() {
    this.modal.open();
  }

}
