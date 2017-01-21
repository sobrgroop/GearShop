import {Component} from '@angular/core';
import {CategoryDataService} from "./category-data.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [CategoryDataService]
})
export class AppComponent {
  title = 'app works!';

  constructor(private categoryDataService: CategoryDataService) {
  }


}
