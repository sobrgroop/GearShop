import {Routes} from "@angular/router";
import {ProductComponent} from "./product/product.component";

export const routes: Routes = [
  {path: 'category/:id', component: ProductComponent}
];
