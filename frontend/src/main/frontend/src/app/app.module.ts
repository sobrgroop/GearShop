import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {RouterModule} from "@angular/router";
import {LocalStorageModule} from "angular-2-local-storage";
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";
import {AppComponent} from "./app.component";
import {CategoryComponent} from "./category/category.component";
import {ProductComponent} from "./product/product.component";
import {routes} from "./app.routes";
import {CartComponent} from "./cart/cart.component";
import {AddToCartDirective} from "./add-to-cart.directive";
import {RemoveFromCartDirective} from "./remove-from-cart.directive";
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {RegistrationComponent} from "./registration/registration.component";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CategoryComponent,
    ProductComponent,
    CartComponent,
    AddToCartDirective,
    RemoveFromCartDirective,
    LoginComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(routes),
    LocalStorageModule.withConfig({
      storageType: 'localStorage',
      notifyOptions: {
        setItem: true,
        removeItem: true
      }
    }),
    Ng2Bs3ModalModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
