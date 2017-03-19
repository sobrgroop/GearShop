import {Component, ViewChild, OnInit, OnDestroy} from "@angular/core";
import {LoginComponent} from "./login/login.component";
import {Router} from "@angular/router";
import {RegistrationComponent} from "./registration/registration.component";
import {CartComponent} from "./cart/cart.component";

const template = require('./app.component.html');
const style = require('./app.component.css');

@Component({
  selector: 'app-root',
  template: template,
  styles: [style]
})
export class AppComponent implements OnInit, OnDestroy {

  @ViewChild(CartComponent)
  private readonly cart: CartComponent;

  @ViewChild(LoginComponent)
  private readonly login: LoginComponent;

  @ViewChild(RegistrationComponent)
  private readonly signUp: RegistrationComponent;

  private onRouterEvent: any;

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    this.onRouterEvent = this.router.events.subscribe(() =>
      this.closeModals()
    );
  }

  ngOnDestroy(): void {
    this.onRouterEvent.unsubscribe();
  }

  closeModals(): void {
    this.cart.close();
    this.login.close();
    this.signUp.close();
  }

}
