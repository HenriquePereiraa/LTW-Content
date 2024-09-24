package ltw.content.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.TransformUtil;

import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import ltw.content.rest.client.dto.v1_0.LTW_content;
import ltw.content.rest.client.http.HttpInvoker;
import ltw.content.rest.client.pagination.Page;
import ltw.content.rest.client.resource.v1_0.LTW_contentResource;
import ltw.content.rest.client.serdes.v1_0.LTW_contentSerDes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Henrique Pereira
 * @generated
 */
@Generated("")
public abstract class BaseLTW_contentResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_ltw_contentResource.setContextCompany(testCompany);

		LTW_contentResource.Builder builder = LTW_contentResource.builder();

		ltw_contentResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		LTW_content ltw_content1 = randomLTW_content();

		String json = objectMapper.writeValueAsString(ltw_content1);

		LTW_content ltw_content2 = LTW_contentSerDes.toDTO(json);

		Assert.assertTrue(equals(ltw_content1, ltw_content2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		LTW_content ltw_content = randomLTW_content();

		String json1 = objectMapper.writeValueAsString(ltw_content);
		String json2 = LTW_contentSerDes.toJSON(ltw_content);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		LTW_content ltw_content = randomLTW_content();

		ltw_content.setMotorcycleManufacturing(regex);
		ltw_content.setMotorcycleName(regex);
		ltw_content.setUserName(regex);

		String json = LTW_contentSerDes.toJSON(ltw_content);

		Assert.assertFalse(json.contains(regex));

		ltw_content = LTW_contentSerDes.toDTO(json);

		Assert.assertEquals(regex, ltw_content.getMotorcycleManufacturing());
		Assert.assertEquals(regex, ltw_content.getMotorcycleName());
		Assert.assertEquals(regex, ltw_content.getUserName());
	}

	@Test
	public void testGetAllLTW_contents() throws Exception {
		Page<LTW_content> page = ltw_contentResource.getAllLTW_contents();

		long totalCount = page.getTotalCount();

		LTW_content ltw_content1 = testGetAllLTW_contents_addLTW_content(
			randomLTW_content());

		LTW_content ltw_content2 = testGetAllLTW_contents_addLTW_content(
			randomLTW_content());

		page = ltw_contentResource.getAllLTW_contents();

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(ltw_content1, (List<LTW_content>)page.getItems());
		assertContains(ltw_content2, (List<LTW_content>)page.getItems());
		assertValid(page, testGetAllLTW_contents_getExpectedActions());
	}

	protected Map<String, Map<String, String>>
			testGetAllLTW_contents_getExpectedActions()
		throws Exception {

		Map<String, Map<String, String>> expectedActions = new HashMap<>();

		return expectedActions;
	}

	protected LTW_content testGetAllLTW_contents_addLTW_content(
			LTW_content ltw_content)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testAddLTW_content() throws Exception {
		LTW_content randomLTW_content = randomLTW_content();

		LTW_content postLTW_content = testAddLTW_content_addLTW_content(
			randomLTW_content);

		assertEquals(randomLTW_content, postLTW_content);
		assertValid(postLTW_content);
	}

	protected LTW_content testAddLTW_content_addLTW_content(
			LTW_content ltw_content)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteLTW_content() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteLTW_content() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetLTW_content() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetLTW_content() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetLTW_contentNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutLTW_Content() throws Exception {
		Assert.assertTrue(false);
	}

	protected void assertContains(
		LTW_content ltw_content, List<LTW_content> ltw_contents) {

		boolean contains = false;

		for (LTW_content item : ltw_contents) {
			if (equals(ltw_content, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			ltw_contents + " does not contain " + ltw_content, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		LTW_content ltw_content1, LTW_content ltw_content2) {

		Assert.assertTrue(
			ltw_content1 + " does not equal " + ltw_content2,
			equals(ltw_content1, ltw_content2));
	}

	protected void assertEquals(
		List<LTW_content> ltw_contents1, List<LTW_content> ltw_contents2) {

		Assert.assertEquals(ltw_contents1.size(), ltw_contents2.size());

		for (int i = 0; i < ltw_contents1.size(); i++) {
			LTW_content ltw_content1 = ltw_contents1.get(i);
			LTW_content ltw_content2 = ltw_contents2.get(i);

			assertEquals(ltw_content1, ltw_content2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<LTW_content> ltw_contents1, List<LTW_content> ltw_contents2) {

		Assert.assertEquals(ltw_contents1.size(), ltw_contents2.size());

		for (LTW_content ltw_content1 : ltw_contents1) {
			boolean contains = false;

			for (LTW_content ltw_content2 : ltw_contents2) {
				if (equals(ltw_content1, ltw_content2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				ltw_contents2 + " does not contain " + ltw_content1, contains);
		}
	}

	protected void assertValid(LTW_content ltw_content) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("contentId", additionalAssertFieldName)) {
				if (ltw_content.getContentId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("createDate", additionalAssertFieldName)) {
				if (ltw_content.getCreateDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("modifiedDate", additionalAssertFieldName)) {
				if (ltw_content.getModifiedDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"motorcycleManufacturing", additionalAssertFieldName)) {

				if (ltw_content.getMotorcycleManufacturing() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("motorcycleName", additionalAssertFieldName)) {
				if (ltw_content.getMotorcycleName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("motorcycleYear", additionalAssertFieldName)) {
				if (ltw_content.getMotorcycleYear() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (ltw_content.getUserId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userName", additionalAssertFieldName)) {
				if (ltw_content.getUserName() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<LTW_content> page) {
		assertValid(page, Collections.emptyMap());
	}

	protected void assertValid(
		Page<LTW_content> page,
		Map<String, Map<String, String>> expectedActions) {

		boolean valid = false;

		java.util.Collection<LTW_content> ltw_contents = page.getItems();

		int size = ltw_contents.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);

		assertValid(page.getActions(), expectedActions);
	}

	protected void assertValid(
		Map<String, Map<String, String>> actions1,
		Map<String, Map<String, String>> actions2) {

		for (String key : actions2.keySet()) {
			Map action = actions1.get(key);

			Assert.assertNotNull(key + " does not contain an action", action);

			Map<String, String> expectedAction = actions2.get(key);

			Assert.assertEquals(
				expectedAction.get("method"), action.get("method"));
			Assert.assertEquals(expectedAction.get("href"), action.get("href"));
		}
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					ltw.content.rest.dto.v1_0.LTW_content.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		LTW_content ltw_content1, LTW_content ltw_content2) {

		if (ltw_content1 == ltw_content2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("contentId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						ltw_content1.getContentId(),
						ltw_content2.getContentId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("createDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						ltw_content1.getCreateDate(),
						ltw_content2.getCreateDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("modifiedDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						ltw_content1.getModifiedDate(),
						ltw_content2.getModifiedDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"motorcycleManufacturing", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						ltw_content1.getMotorcycleManufacturing(),
						ltw_content2.getMotorcycleManufacturing())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("motorcycleName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						ltw_content1.getMotorcycleName(),
						ltw_content2.getMotorcycleName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("motorcycleYear", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						ltw_content1.getMotorcycleYear(),
						ltw_content2.getMotorcycleYear())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						ltw_content1.getUserId(), ltw_content2.getUserId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						ltw_content1.getUserName(),
						ltw_content2.getUserName())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		if (clazz.getClassLoader() == null) {
			return new java.lang.reflect.Field[0];
		}

		return TransformUtil.transform(
			ReflectionUtil.getDeclaredFields(clazz),
			field -> {
				if (field.isSynthetic()) {
					return null;
				}

				return field;
			},
			java.lang.reflect.Field.class);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_ltw_contentResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_ltw_contentResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		if (entityModel == null) {
			return Collections.emptyList();
		}

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		return TransformUtil.transform(
			getEntityFields(),
			entityField -> {
				if (!Objects.equals(entityField.getType(), type) ||
					ArrayUtil.contains(
						getIgnoredEntityFieldNames(), entityField.getName())) {

					return null;
				}

				return entityField;
			});
	}

	protected String getFilterString(
		EntityField entityField, String operator, LTW_content ltw_content) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("contentId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("createDate")) {
			if (operator.equals("between")) {
				Date date = ltw_content.getCreateDate();

				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(date.getTime() - (2 * Time.SECOND)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(date.getTime() + (2 * Time.SECOND)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(ltw_content.getCreateDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("modifiedDate")) {
			if (operator.equals("between")) {
				Date date = ltw_content.getModifiedDate();

				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(date.getTime() - (2 * Time.SECOND)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(date.getTime() + (2 * Time.SECOND)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(ltw_content.getModifiedDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("motorcycleManufacturing")) {
			Object object = ltw_content.getMotorcycleManufacturing();

			String value = String.valueOf(object);

			if (operator.equals("contains")) {
				sb = new StringBundler();

				sb.append("contains(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 2)) {
					sb.append(value.substring(1, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else if (operator.equals("startswith")) {
				sb = new StringBundler();

				sb.append("startswith(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 1)) {
					sb.append(value.substring(0, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else {
				sb.append("'");
				sb.append(value);
				sb.append("'");
			}

			return sb.toString();
		}

		if (entityFieldName.equals("motorcycleName")) {
			Object object = ltw_content.getMotorcycleName();

			String value = String.valueOf(object);

			if (operator.equals("contains")) {
				sb = new StringBundler();

				sb.append("contains(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 2)) {
					sb.append(value.substring(1, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else if (operator.equals("startswith")) {
				sb = new StringBundler();

				sb.append("startswith(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 1)) {
					sb.append(value.substring(0, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else {
				sb.append("'");
				sb.append(value);
				sb.append("'");
			}

			return sb.toString();
		}

		if (entityFieldName.equals("motorcycleYear")) {
			sb.append(String.valueOf(ltw_content.getMotorcycleYear()));

			return sb.toString();
		}

		if (entityFieldName.equals("userId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("userName")) {
			Object object = ltw_content.getUserName();

			String value = String.valueOf(object);

			if (operator.equals("contains")) {
				sb = new StringBundler();

				sb.append("contains(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 2)) {
					sb.append(value.substring(1, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else if (operator.equals("startswith")) {
				sb = new StringBundler();

				sb.append("startswith(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 1)) {
					sb.append(value.substring(0, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else {
				sb.append("'");
				sb.append(value);
				sb.append("'");
			}

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected LTW_content randomLTW_content() throws Exception {
		return new LTW_content() {
			{
				contentId = RandomTestUtil.randomLong();
				createDate = RandomTestUtil.nextDate();
				modifiedDate = RandomTestUtil.nextDate();
				motorcycleManufacturing = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				motorcycleName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				motorcycleYear = RandomTestUtil.randomInt();
				userId = RandomTestUtil.randomLong();
				userName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected LTW_content randomIrrelevantLTW_content() throws Exception {
		LTW_content randomIrrelevantLTW_content = randomLTW_content();

		return randomIrrelevantLTW_content;
	}

	protected LTW_content randomPatchLTW_content() throws Exception {
		return randomLTW_content();
	}

	protected LTW_contentResource ltw_contentResource;
	protected com.liferay.portal.kernel.model.Group irrelevantGroup;
	protected com.liferay.portal.kernel.model.Company testCompany;
	protected com.liferay.portal.kernel.model.Group testGroup;

	protected static class BeanTestUtil {

		public static void copyProperties(Object source, Object target)
			throws Exception {

			Class<?> sourceClass = _getSuperClass(source.getClass());

			Class<?> targetClass = target.getClass();

			for (java.lang.reflect.Field field :
					sourceClass.getDeclaredFields()) {

				if (field.isSynthetic()) {
					continue;
				}

				Method getMethod = _getMethod(
					sourceClass, field.getName(), "get");

				Method setMethod = _getMethod(
					targetClass, field.getName(), "set",
					getMethod.getReturnType());

				setMethod.invoke(target, getMethod.invoke(source));
			}
		}

		public static boolean hasProperty(Object bean, String name) {
			Method setMethod = _getMethod(
				bean.getClass(), "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod != null) {
				return true;
			}

			return false;
		}

		public static void setProperty(Object bean, String name, Object value)
			throws Exception {

			Class<?> clazz = bean.getClass();

			Method setMethod = _getMethod(
				clazz, "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod == null) {
				throw new NoSuchMethodException();
			}

			Class<?>[] parameterTypes = setMethod.getParameterTypes();

			setMethod.invoke(bean, _translateValue(parameterTypes[0], value));
		}

		private static Method _getMethod(Class<?> clazz, String name) {
			for (Method method : clazz.getMethods()) {
				if (name.equals(method.getName()) &&
					(method.getParameterCount() == 1) &&
					_parameterTypes.contains(method.getParameterTypes()[0])) {

					return method;
				}
			}

			return null;
		}

		private static Method _getMethod(
				Class<?> clazz, String fieldName, String prefix,
				Class<?>... parameterTypes)
			throws Exception {

			return clazz.getMethod(
				prefix + StringUtil.upperCaseFirstLetter(fieldName),
				parameterTypes);
		}

		private static Class<?> _getSuperClass(Class<?> clazz) {
			Class<?> superClass = clazz.getSuperclass();

			if ((superClass == null) || (superClass == Object.class)) {
				return clazz;
			}

			return superClass;
		}

		private static Object _translateValue(
			Class<?> parameterType, Object value) {

			if ((value instanceof Integer) &&
				parameterType.equals(Long.class)) {

				Integer intValue = (Integer)value;

				return intValue.longValue();
			}

			return value;
		}

		private static final Set<Class<?>> _parameterTypes = new HashSet<>(
			Arrays.asList(
				Boolean.class, Date.class, Double.class, Integer.class,
				Long.class, Map.class, String.class));

	}

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseLTW_contentResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private ltw.content.rest.resource.v1_0.LTW_contentResource
		_ltw_contentResource;

}