import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/map";

@Injectable()
export class CategoryService {

  constructor(private http: Http) {
  }

  getCategories() {
    return this.http.get('/categories').map(res => res.json());
  }

  getProducts(id) {
    return this.http.get('/categories/' + id).map(res => res.json());
  }

}
