import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Food Item Class
class FoodItem {

    String name;
    int price;

    public FoodItem(String name, int price) {

        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {

        return name + " - ₹" + price;
    }
}

// Main GUI Class
public class FoodOrderingSystemGUI extends JFrame
        implements ActionListener {

    // Menu Items
    FoodItem[] menu = {

            new FoodItem("Burger", 120),
            new FoodItem("Pizza", 250),
            new FoodItem("Sandwich", 100),
            new FoodItem("French Fries", 90),
            new FoodItem("Pasta", 180),
            new FoodItem("Cold Drink", 60)
    };

    ArrayList<FoodItem> cart =
            new ArrayList<>();
    JLabel titleLabel;

    JComboBox<FoodItem> menuBox;

    JButton addButton,
            billButton,
            clearButton;

    JTextArea resultArea;

    public FoodOrderingSystemGUI() {
        setTitle("Online Food Ordering System");

        setSize(700, 600);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(
                new Color(255, 248, 220));
        titleLabel = new JLabel(
                "ONLINE FOOD ORDERING SYSTEM");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 26));

        titleLabel.setBounds(120, 20, 500, 40);

        add(titleLabel);

        JLabel menuLabel =
                new JLabel("Select Food Item:");

        menuLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        menuLabel.setBounds(70, 100, 180, 30);

        add(menuLabel);

        menuBox = new JComboBox<>(menu);

        menuBox.setBounds(260, 100, 250, 35);

        menuBox.setFont(
                new Font("Arial", Font.PLAIN, 16));

        add(menuBox);

        addButton = new JButton("Add To Cart");

        addButton.setBounds(80, 180, 170, 45);

        addButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        addButton.addActionListener(this);

        add(addButton);

        billButton = new JButton("Generate Bill");

        billButton.setBounds(270, 180, 170, 45);

        billButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        billButton.addActionListener(this);

        add(billButton);

        clearButton = new JButton("Clear Cart");

        clearButton.setBounds(460, 180, 150, 45);

        clearButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        clearButton.addActionListener(this);

        add(clearButton);
        resultArea = new JTextArea();

        resultArea.setBounds(70, 270, 540, 220);

        resultArea.setFont(
                new Font("Monospaced",
                        Font.BOLD, 16));

        resultArea.setEditable(false);

        add(resultArea);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addButton) {

            FoodItem selectedItem =
                    (FoodItem) menuBox.getSelectedItem();

            cart.add(selectedItem);

            resultArea.setText(
                    selectedItem.name +
                    " Added To Cart!");
        }

        else if(e.getSource() == billButton) {

            if(cart.isEmpty()) {

                resultArea.setText(
                        "Cart is Empty!");

                return;
            }

            String bill =
                    "===== ORDER SUMMARY =====\n\n";

            int total = 0;

            for(FoodItem item : cart) {

                bill += item.name +
                        " - ₹" +
                        item.price + "\n";

                total += item.price;
            }

            bill += "\n-------------------------";

            bill += "\nTotal Amount : ₹" + total;

            resultArea.setText(bill);
        }
        else if(e.getSource() == clearButton) {

            cart.clear();

            resultArea.setText(
                    "Cart Cleared Successfully!");
        }
    }
    public static void main(String[] args) {

        new FoodOrderingSystemGUI();
    }
}