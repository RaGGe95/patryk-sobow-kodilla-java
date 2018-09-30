package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    ItemDao itemDao;
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testItemDao(){
        //Given
        Product product1 = new Product("Marchewka");
        Item item = new Item(product1, new BigDecimal(10), 1, new BigDecimal(0));


        //When
        itemDao.save(item);

        //Then
        int idItem = item.getId();
        Item readItem = itemDao.findOne(idItem);
        Assert.assertEquals(idItem, readItem.getId());

        //Clean up
        itemDao.delete(idItem);
    }

    @Test
    public void testInvoiceDao(){
        //Given
        Product product1 = new Product("Marchewka");
        Product product2 = new Product("Groszek");

        Item item1 = new Item(product1, new BigDecimal(10), 1, new BigDecimal(0));
        Item item2 = new Item(product2, new BigDecimal(1), 1, new BigDecimal(0));

        Invoice invoice = new Invoice("001", Arrays.asList(item1, item2));

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);

        //Then
        int id = invoice.getId();
        Invoice readInvoice = invoiceDao.findOne(id);
        Assert.assertEquals(id, readInvoice.getId());

        //Clean up
        invoiceDao.delete(id);
    }
}
