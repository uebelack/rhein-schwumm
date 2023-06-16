describe('Test', () => {
  it('should work', () => {
    cy.visit('/');
    cy.get('h1').should('contain', 'Rhein Schwumm');
  })
});