import {Outlet} from "react-router";
import {Container, Col, Row} from "react-bootstrap";
import {AppNav} from "./AppNav.jsx";

export default function MyLayout() {

return(
        <>
            <Container>
                <Row>
                    <AppNav/>
                </Row>
                <Row>
                    <Col><h1>CSD230 : Vite + React + Quarkus</h1></Col>
                </Row>
                <Row>
                    <Col>
                        <Outlet/>
                    </Col>
                </Row>
            </Container>
            {/*<header>*/}
            {/*    <h1>CSD230 : Vite + React + Quarkus</h1>*/}
            {/*</header>*/}
            {/*<main>*/}
            {/*</main>*/}
            {/*<footer>*/}
            {/*    <h4>Footer</h4>*/}
            {/*</footer>*/}
        </>
    )
}