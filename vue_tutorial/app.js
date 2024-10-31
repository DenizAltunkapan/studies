const app = Vue.createApp({
    data(){
        return {
            title: "Hello, Vue :D",
            counter:0,
            visibility: false,
            users: [
                {name: 'Deniz', major: 'Software Engineering'},
                {name: 'Maxi', major: 'Computer Science'},
                {name: ''}
            ]
        }
    },
    methods: {
        changeTitle(){
            this.title = this.inputValue
        },
        changeVisibility(){
            this.visibility = !this.visibility
        }
    }
})

app.mount('#app')