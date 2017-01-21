/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { CategoryDataService } from './category-data.service';
import {Category} from "./category";

describe('CategoryDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CategoryDataService]
    });
  });

  it('should ...', inject([CategoryDataService], (service: CategoryDataService) => {
    expect(service).toBeTruthy();
  }));

  describe('#getCategories()', () => {
    it('should return an empty array by default', inject([CategoryDataService], (service: CategoryDataService) => {
      expect(service.getCategories()).toEqual([]);
    }));
  })
});
