import React, {Component} from "react";

// reactstrap components
import {Card, CardImg, CardHeader,CardBody, CardTitle, CardText,
    Button,
    Label,
    FormGroup,
    Input,
    NavItem,
    NavLink,
    Nav,
    TabContent,
    TabPane,
    Container,
    Row,
    Col,
  } from "reactstrap";

class EventData extends Component {

  constructor(props) {
    super(props);
  }

    state = {
        name: null,
        description: null,
        location: null,
        fromDate: null,
        toDate: null,
        createTime: false
    }

    getEventById() {
      let url = '/event/' + this.props.eventId
        fetch(url)
            .then(res => res.json())
            .then(json => {
                this.setState({
                    name: json.name,
                    description: json.description,
                    location: json.location,
                    fromDate: json.fromDate,
                    toDate: json.toDate,
                    createTime: json.createTime})
                });
    }

    componentDidMount() {
        this.getEventById()
    } 


    render() {
        return(
            <Card style={{width: '22rem', height: "30.6rem"}} className="text-center" color="warning">
                <CardHeader style={{borderRadius: "calc(1.25rem - 9px) calc(1.25rem - 9px) 0 0", backgroundColor: "rgba(255, 255, 255, 0.30)"}}>
                    {this.state.name}
                </CardHeader>
                <CardBody>
                        {this.state.toDate === null || this.state.toDate === this.state.fromDate ?
                        <CardText>{this.state.fromDate}</CardText> :
                        <CardText>{this.state.fromDate} - {this.state.toDate}</CardText>}
                    <CardText>{this.state.location}</CardText>
                    <CardText>{this.state.description}</CardText>
                    <Button href="/#" color="primary">Join</Button>
                </CardBody>
            </Card>
           
        )
    }
}

export default EventData