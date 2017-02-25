import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {RouterModule} from "@angular/router";
import {LocalStorageModule} from "angular-2-local-storage";
import {AppComponent} from "./app.component";
import {CategoryComponent} from "./category/category.component";
import {ProductComponent} from "./product/product.component";
import {CategoryService} from "./category.service";
import {routes} from "./app.routes";
import {CartComponent} from "./cart/cart.component";
import {AddToCartDirective} from "./add-to-cart.directive";
import { RemoveFromCartDirective } from './remove-from-cart.directive';

@NgModule({
  declarations: [
    AppComponent,
    CategoryComponent,
    ProductComponent,
    CartComponent,
    AddToCartDirective,
    RemoveFromCartDirective
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
    })
  ],
  providers: [CategoryService],
  bootstrap: [AppComponent, CategoryComponent, CartComponent]
})
export class AppModule {
}
