import {Injectable} from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from 'rxjs/Rx';

@Injectable()
export class CategoryService {

  constructor(private http: Http) {
  }

  getCategories() {
    return this.http.get('/categories').map((res:Response) => res.json());
  }
}
