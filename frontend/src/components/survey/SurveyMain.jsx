/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';

import Button from '../common/Button';
import Option from './Option';
import axios from 'axios';

const surveyMain = css({
  width: '80%',
  height: '100%',
  marginTop: '50px',
  display: 'flex',
  flexDirection: 'column',
  justifyContent: 'space-between',
  color: '#FFF',
  '.title': {
    fontSize: '2rem',
    marginLeft: '15%',
    marginRight: '15%',
  },
  '.description': {
    marginLeft: '15%',
    marginRight: '15%',
    marginBottom: '30px',
  },
  '.options': {
    minHeight: '75%',
    maxHeight: '80%',
  },
});

const buttonArea = css({
  height: '7%',
  marginLeft: '15%',
  marginRight: '15%',
  display: 'flex',
  justifyContent: 'space-around',
  alignItems: 'center',
  '@media (max-width: 800px)': {
    flexDirection: 'column',
  },
  // backgroundColor: "#FFF",
});

function SurveyMain(props) {
  const { data } = props;
  const URL = 'http://52.78.118.174:8080';

  const getTestApi = async (param) => {
    try {
      console.log('파라미터', param);
      let res = await axios.get(`${URL}/api/question/2`);
      console.log('결과는', res);
    } catch (err) {
      console.error(err);
      throw err;
    }
  };

  return (
    <div css={surveyMain}>
      <div
        className="title"
        onClick={() => {
          let param = {};
          getTestApi(param);
        }}
      >
        {data.id}. {data.title}
      </div>
      <div className="description">{data.description}</div>
      <div className="options">
        {data.options.map((option, index) => (
          <Option key={`${option.id}-${index}`} data={option} />
        ))}
      </div>
      <div css={buttonArea}>
        {/* <img
          src="https://image.tmdb.org/t/p/original/3FyO7Z8WigeCQsUpW4B1x3qfmFx.jpg"
          alt="헬렌.."
          height="100px"
          width="100px"
        /> */}

        <Button
          color="default"
          size="large"
          value="Prev"
          variant="filled"
          iconPosition="back"
        />
        <Button
          color="default"
          size="large"
          value="Next"
          variant="filled"
          iconPosition="back"
        />
      </div>
    </div>
  );
}

export default SurveyMain;
