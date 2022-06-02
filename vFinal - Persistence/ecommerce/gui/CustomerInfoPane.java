package ecommerce.gui;

import ecommerce.core.Customer;

class CustomerInfoPane extends AbstractCustomerPane {
    
    public CustomerInfoPane(Customer customer) {
        super("Customer Info", customer);
        this.customer = customer;
        textArea.setText(customer.forDisplay());
    }

    @Override
    protected void update() {
        textArea.setText(customer.forDisplay());
    }
}
