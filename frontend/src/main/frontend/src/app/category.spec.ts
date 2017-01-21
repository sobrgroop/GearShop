import {Category} from './category';

describe('Category', () => {
  it('should create an instance', () => {
    expect(new Category()).toBeTruthy();
  });

  it('should accept values in the constructor', () => {
    let category = new Category({
      name: 'category'
    });
  expect(category.name).toEqual('category');
  });
});
