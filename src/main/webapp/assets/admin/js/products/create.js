$(document).ready(function() {
    $(document).on('click', ".btn-add-size", function () {
        const parentTr = $(this).parents('tr');
        const parentTbody = $(this).parents('tbody');
        const firstTd = parentTbody.find('td[rowspan]');
        const rowSpan = firstTd.attr('rowspan');
        firstTd.attr('rowspan', rowSpan+1);
        console.log('___:', rowSpan);
        const cloneTr = `<tr><td>36</td><td><div class='last-column'>
				        <input type='number' class='form-control'/>
				        <button class='btn btn-primary btn-add-size' type='button'>+</button>
				        </div></td></tr>`;
        parentTbody.append(cloneTr);
    });
});
