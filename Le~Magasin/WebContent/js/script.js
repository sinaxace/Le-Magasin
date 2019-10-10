let index = 0; //Global variable to track slides.
let count = 0; //Global variable to track total selected.

/**
 * jQuery code for adding the slideshow feature.
 */
$(document).ready(function () {
    console.log("Starting jQuery");

    //This loop is to grab any checked checkboxes saved to localStorage.
    for (let i = 1; i <= 10; i++) {
        $(`#price${parseInt(localStorage.getItem(`checked${i}`))}`).attr('checked');

    }

    //Only show the first set of table rows.
    $(".scott").hide();
    $(".cowboy").hide();
    $(".russian").hide();
    $(".latin").hide();

    //To remember which box was checked.
    $("input[type=checkbox]").click(function () {
        console.log('checkbox clicked');
        count = 0;
        for (let i = 1; i <= 10; i++) {
            if (document.querySelector(`#price${i}`).checked) {
                localStorage.setItem(`checked${i}`, `${i}`);
                count++;
            } else {
                localStorage.removeItem(`checked${i}`)
            }

        }
        document.querySelector("#count").textContent = count;
    });

    //Next button click event.
    $("#next").click(function () {
        console.log("Hide elements");

        if (index != 4) { index++; }
        else { index = 0 }

        switch (index) {
            case 0:
                $(".latin").hide();
                $(".europe").fadeIn('medium');
                break;
            case 1:
                $(".europe").hide();
                $(".scott").fadeIn('medium');
                break;
            case 2:
                $(".scott").hide();
                $(".cowboy").fadeIn('medium');
                break;
            case 3:
                $(".cowboy").hide();
                $(".russian").fadeIn('medium');
                break;
            case 4:
                $(".russian").hide();
                $(".latin").fadeIn('medium');
        }

        console.log(index);
    });

    //Previous button click event.
    $("#previous").click(function () {
        console.log("Going to previous slide");
        //Makes sure that index only targets the amount of existing rows.
        if (index != 0) { index--; }
        else { index = 4 }

        switch (index) {
            case 0:
                $(".scott").hide();
                $(".europe").fadeIn('medium');
                break;
            case 1:
                $(".cowboy").hide();
                $(".scott").fadeIn('medium');
                break;
            case 2:
                $(".russian").hide();
                $(".cowboy").fadeIn('medium');
                break;
            case 3:
                $(".latin").hide();
                $(".russian").fadeIn('medium');
                break;
            case 4:
                $(".europe").hide();
                $(".latin").fadeIn('medium');
        }

        console.log(index);
    });
});