require File.expand_path("../spec_helper", __FILE__)

module Selenium
  module WebDriver
    describe Mouse do
      compliant_on :driver => :remote, :browser => :htmlunit do
        it "clicks an element" do
          driver.navigate.to url_for("formPage.html")
          driver.mouse.click driver.find_element(:id, "imageButton")
        end

        it "double clicks an element" do
          driver.navigate.to url_for("javascriptPage.html")
          element = driver.find_element(:id, 'doubleClickField')

          driver.mouse.double_click element
          element.value.should == 'DoubleClicked'
        end

        it "context clicks an element" do
          driver.navigate.to url_for("javascriptPage.html")
          element = driver.find_element(:id, 'doubleClickField')

          driver.mouse.context_click element
          element.value.should == 'ContextClicked'
        end

        it "can drag and drop" do
          driver.navigate.to url_for('droppableItems.html')

          draggable = long_wait.until do
            driver.find_element(:id => "draggable")
          end

          droppable = driver.find_element(:id => "droppable")

          driver.mouse.down draggable
          driver.mouse.move droppable
          driver.mouse.up   droppable

          text = droppable.find_element(:tag_name => "p").text
          text.should == "Dropped!"
        end

      end
    end
  end
end
