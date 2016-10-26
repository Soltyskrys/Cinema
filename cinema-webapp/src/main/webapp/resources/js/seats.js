function generateTable(rowNumber, colNumber)
{
    var $table = $('<table class="table" id="seatsTable"/>');
    for (var row = 0; row < rowNumber; row++)
    {
        var $tr = $('<tr />');
        for (var col = 0; col < colNumber; col++)
        {
            var $td = $('<td/>');
            $td.attr('id', 'r' + row + 'c' + col);
            $tr.append($td);
        }
        $table.append($tr);
    }
    return $table;
}

function fillTable($table, seats, $element, onChoose)
{
    seats.forEach(function (seat)
    {
        var $td = $table.find('#r' + seat.row + 'c' + seat.col);
        $el = $element.clone();
        $($el).attr('data-row', seat.row).attr('data-col', seat.col);
        if (seat.alreadyReserved === true)
            $($el).addClass('seatReserved');
        else
            $($el).addClass('seatFree');
        var these = $el;
        $($td).click(function ()
        {
            return onChoose(these);
        });
        $td.append($el);
    })
}

function onChooseSeat($element)
{
    if ($($element).hasClass('seatFree'))
        $($element).removeClass('seatFree').addClass('seatChecked');
    else if ($($element).hasClass('seatChecked'))
        $($element).removeClass('seatChecked').addClass('seatFree');
    else if (($($element).hasClass('seatReserved')))
    {
        alert("To miejsce jest już zajęte!");
    }

}

function reserve()
{
    checkedSeatsRowCol = readCheckedSeats();
    $.ajax({
        type: "POST",
        url: "reserve",
        data: {
            name: $('#name').val(),
            surname: $('#surname').val(),
            email: $('#e-mail').val(),
            phone: $('#phone').val(),
            'seats[]': JSON.stringify(checkedSeatsRowCol)}
        ,
        success: function (data)
        {
            alert('Udało się zarezerwować miesjce!');
            location.reload();
        },
        error: function (data)
        {
            alert("Wystąpił błąd, wprowadź prawidłowe dane");
        }
    });
}

function readCheckedSeats()
{
    return $('.seatChecked').map(function (index, $button)
    {
        return {rowNumber: $($button).data('row'), columnNumber: $($button).data('col')};
    }).get();
}

