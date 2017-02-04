import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import "rxjs/add/operator/map";

@Injectable()
export class ProductService {

  constructor(private http: Http) {
  }

  getProducts(id) {
    return this.http.get('/categories/{id}').map((res: Response) => res.json());
  }

}
