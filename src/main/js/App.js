import React, {Component} from "react";
import ReactDOM from "react-dom";
import RegisterRoute from '../../../frontend/src/components/Route/CreateRoute';
import Routes from '../../../frontend/src/components/Route/Routes';
import axios from "axios";

export class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            routes: []
        }
    }

    componentDidMount() {
        axios.get('/api/routes')
            .then(response => this.setState({routes: response.data}))
    }

    // Deleting Route
    removeRoute = (id) => {
        axios.delete(`/api/routes/${id}`)
            .then(response => this.setState({
                routes: [...this.state.routes.filter(route => route.id !== id)]
            }));
    }

    addRoute = (newRoute) => {
        axios.post('/api/routes', newRoute)
            .then(response => {
                console.log(response.data);
                this.setState({routes: [...this.state.routes, response.data]});
            });
    }

    render() {
        return (
            <div className="container">
                <Header/>
                <RegisterRoute addRoute={this.addRoute}/>
                <Routes routes={this.state.routes} removeRoute={this.removeRoute}/> ]
            </div>
        );
    }
}

export default App;

ReactDOM.render(<App />, document.querySelector("#app"));
