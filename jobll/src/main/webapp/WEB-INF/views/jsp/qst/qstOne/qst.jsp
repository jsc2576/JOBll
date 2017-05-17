<table id="qstViewTable" class="table" border="1">
	<tr>
		<td><div id="idx"></div></td>
		<td>${ qst.qst_idx }</td>
		<td><div id="sbjt"></div></td>
		<td>${ qst.qst_sbjt }</td>
	</tr>
	<tr>
		<td><div id="id"></div></td>
		<td>${ qst.usr_id }</td>
		<td><div id="date"></div></td>
		<td>${ qst.reg_date }</td>
	</tr>
	<tr><td colspan="4"><div id="conts"></div></td></tr>
	<tr>
		<td colspan="4">${ qst.qst_conts }</td>
	</tr>
</table>

<form action="/qstWrite" id="re_write" method="post">
	<input type="hidden" name="qst_idx" value='${ qst.qst_idx }'/>
	<input type="hidden" name="high_qst_idx" value='${ qst.high_qst_idx }' id="high_idx"/>
	<input type="submit" id="write_submit"/>
</form>