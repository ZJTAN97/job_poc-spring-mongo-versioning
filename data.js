db.createCollection("person", {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            description: "Document describing a person",
            required: ["name", "age", "hobbies"],
            properties: {
                name: {
                    bsonType: "string",
                    description: "Name must be a string and required",
                },
                age: {
                    bsonType: "number",
                    description: "Age must be a number and required",
                    minimum: 1,
                    maximum: 100,
                },
                hobbies: {
                    bsonType: "array",
                    description: "Hobbies must be an array of strings",
                    minItems: 1,
                    uniqueItems: true,
                    items: {
                        bsonType: "string",
                    },
                },
                education: {
                    enum: ["BASIC", "INTERMEDIATE", "ADVANCED"],
                },
            },
        },
    },
});

db.person.insertMany([
    {
        name: "Test1",
        age: 12,
        hobbies: ["testing"],
        education: "BASIC",
    },
    {
        name: "Test2",
        age: 13,
        hobbies: ["testing2"],
        education: "BASIC",
    },
    {
        name: "Test3",
        age: 14,
        hobbies: ["testing3"],
        education: "BASIC",
    },
    {
        name: "Test4",
        age: 13,
        hobbies: ["testing4"],
        education: "BASIC",
    },
    {
        name: "Test5",
        age: 14,
        hobbies: ["testing5"],
        education: "BASIC",
    },
]);