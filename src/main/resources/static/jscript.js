document.addEventListener("DOMContentLoaded", function() {

    var unsortedNumbersArray = [];

    $('#addNumber').click(function(e) {
        e.preventDefault();

        var number = $('#number').val();

        unsortedNumbersArray.push(number);

        var unsortedNumbersTable = '';
        unsortedNumbersTable += '<td>' + number + '</td>';

        $('#unsortedNumbers').html('<tr>' + unsortedNumbersTable + '</tr>');
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