/*!

=========================================================
* Paper Kit React - v1.3.0
=========================================================

* Product Page: https://www.creative-tim.com/product/paper-kit-react

* Copyright 2021 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://github.com/creativetimofficial/paper-kit-react/blob/main/LICENSE.md)

* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

*/
import React from "react";

// reactstrap components
import { Button, Card, CardBody, CardTitle, CardText, Form, Input, Container, Row, Col } from "reactstrap";

// core components
import ExamplesNavbar from "components/Navbars/ExamplesNavbar.js";
import EventParticipants from "components/Data/EventPage/EventParticipants";
import EventData from "components/Data/EventPage/EventData";
import Messages from "components/Data/EventPage/Messages";

function EventPage() {
  document.documentElement.classList.remove("nav-open");
  React.useEffect(() => {
    document.body.classList.add("login-page");
    return function cleanup() {
      document.body.classList.remove("login-page");
    };
  });

  return (
    <>
      <ExamplesNavbar />
      <div
        className="page-header"
        style={{
          backgroundImage:
            "url(" + require("assets/img/login-page-bg.jpg").default + ")",
        }}
      >
        <div className="filter" />
        <Container>
          <Row>
            <Col className="ml-auto mr-auto" lg="4">
                <EventData eventId="1"/>
            </Col>
            <Col className="ml-auto mr-auto" lg="8">
              <Row>
              <Col className="ml-auto mr-auto" lg="12">
                <Messages eventId="1"/>
                </Col>
              </Row>
              <Row>
                <Col>
                  <Card style={{width: '23rem', height: "20rem"}} className="text-center" color="info">
                      <CardBody>
                          <CardTitle>To Bring</CardTitle>
                          <CardText>With supporting text below as a natural lead-in to additional content.</CardText>
                          <Button href="/#" color="danger">Go somewhere</Button>
                      </CardBody>
                  </Card>
                </Col>
                <Col>
                  <Card style={{width: '19rem', height: "20rem"}} className="text-center">
                      <CardBody>
                          <CardTitle>To Do</CardTitle>
                          <CardText>With supporting text below as a natural lead-in to additional content.</CardText>
                          <Button href="/#" color="primary">Go somewhere</Button>
                      </CardBody>
                  </Card>
                </Col>
              </Row>
            </Col>
          </Row>
          <Row>
            <Col className="ml-auto mr-auto" lg="12">
              <EventParticipants eventId="1"/>            
            </Col>
          </Row>
        </Container>
        <div className="footer register-footer text-center">
          <h6>
            © {new Date().getFullYear()}, made with{" "}
            <i className="fa fa-heart heart" /> by Code Turtles
          </h6>
        </div>
      </div>
    </>
  );
}

export default EventPage;
