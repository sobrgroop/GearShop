import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import {Observable} from "rxjs";
import "rxjs/add/operator/map";
import {CartItem} from "./cart-item";

@Injectable()
export class CartService {

  constructor(private http: Http) {
  }

  // this will be replaced to another component
  login(email: string, password: string): Observable<any> {
    return this.http.post('/login', {email, password});
  }

  checkout(phone: string, cartItems: CartItem[]) {
    return this.http.post('/cartItems', {phone, cartItems});
  }

}
