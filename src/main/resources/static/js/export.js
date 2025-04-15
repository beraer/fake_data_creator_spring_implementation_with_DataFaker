const fakeData = /*[[${jsonData}]]*/ '[]';
const parsedData = JSON.parse(fakeData);
const headers = /*[[${headers}]]*/ {};

    function downloadFile(content, fileName, contentType) {
    const a = document.createElement("a");
    const file = new Blob([content], { type: contentType });
    a.href = URL.createObjectURL(file);
    a.download = fileName;
    a.click();
}

    function convertToCSV(data) {
    const headerNames = ['firstName', 'lastName', 'birthDate'];
    const headerLabels = [
    headers['firstName'] || 'First Name',
    headers['lastName'] || 'Last Name',
    headers['birthDate'] || 'Date of Birth'
    ];

    if (data.length > 0 && data[0].additionalFields) {
    Object.keys(data[0].additionalFields).forEach(key => {
    headerNames.push(key);
    headerLabels.push(headers[key] || key);
});
}
    let csvContent = headerLabels.join(',') + '\n';

    data.forEach(person => {
    const row = [
    `"${person.firstName}"`,
    `"${person.lastName}"`,
    `"${person.birthDate}"`
    ];


    headerNames.slice(3).forEach(header => {
    const value = person.additionalFields[header] || '';
    row.push(`"${value}"`);
});

    csvContent += row.join(',') + '\n';
});

    return csvContent;
}

    document.getElementById('downloadCsv').addEventListener('click', function() {
    const csvContent = convertToCSV(parsedData);
    downloadFile(csvContent, 'fake-data.csv', 'text/csv');
});

    document.getElementById('downloadJson').addEventListener('click', function() {
    const jsonContent = JSON.stringify(parsedData, null, 2);
    downloadFile(jsonContent, 'fake-data.json', 'application/json');
});