import { GearshopPage } from './app.po';

describe('gearshop App', function() {
  let page: GearshopPage;

  beforeEach(() => {
    page = new GearshopPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
