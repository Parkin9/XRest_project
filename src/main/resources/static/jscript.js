document.addEventListener("DOMContentLoaded", function() {

    var unsortedNumbersArray = [];

    var unsortedNumbersTable = '';

    $('#addNumber').click(function(e) {
        e.preventDefault();

        var number = $('#number').val();

        if($.isNumeric(number)) {

            unsortedNumbersArray.push(number);

            unsortedNumbersTable += '<td>' + number + '</td>';
            $('#unsortedNumbers').html('<tr>' + unsortedNumbersTable + '</tr>');
            $('#sortedNumbers').html('');

        } else {

            $('#sortedNumbers').html('<tr><td>To nie jest liczba.</td></tr>');
        }
    });


    $('#sendNumbers').click(function(e) {
        e.preventDefault();

        var order = $('#order').val();

        var myJson = { numbers: unsortedNumbersArray, order: order };

        $.ajax({
            type: 'POST',
            url: 'Http://localhost:8080/numbers/sort-command',
            data: JSON.stringify(myJson),
            dataType: 'json',
            contentType: 'application/json',
            success: function(sortedNumbers) {

                var sortedNumbersTable = '';

                for(var i = 0; i < sortedNumbers.numbers.length; i++) {

                    sortedNumbersTable += '<td>' + sortedNumbers.numbers[i] + '</td>';
                }

                $('#sortedNumbers').html('<tr>' + sortedNumbersTable + '</tr>');
            }
        });
    });
});