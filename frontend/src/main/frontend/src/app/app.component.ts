import {Component} from "@angular/core";
import {Router} from "@angular/router";

const template = require('./app.component.html');
const styles = require('./app.component.css');

@Component({
  selector: 'app-root',
  template: template,
  styles: [styles]
})
export class AppComponent {

  constructor(public router: Router) {
  }

}
